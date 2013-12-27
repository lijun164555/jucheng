package com.jucheng.ec.app.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import com.jucheng.ec.app.model.Menu;
import com.jucheng.ec.app.model.MenuType;
import com.jucheng.ec.app.model.StringUtil;
import com.jucheng.ec.app.service.MenuServiceImpl;
import com.jucheng.ec.app.service.MenuTypeServiceImpl;
import com.jucheng.ec.app.service.PoiService;

@Controller
public class MenuController {

	@Autowired
	protected transient MenuServiceImpl menuService;
	@Autowired
	protected transient MenuTypeServiceImpl menuTypeService;
	@Autowired
	protected transient PoiService poiService;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(ModelMap model) {
		int storeId = 1;
		List<MenuType> list = menuTypeService.queryMenuList(storeId);
		model.addAttribute("list", list);
		return "menu";
	}

	@RequestMapping(value = "/addmenu", method = RequestMethod.GET)
	public String addmenu(String name, int price, String picUrl, int type,
			String secondName, String thirdName)
			throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		Menu menu = new Menu();
		menu.setName(name);
		menu.setPicUrl(picUrl);
		menu.setPrice(price);
		menu.setTypeId(type);
		menu.setStoreId(1);
		menu.setStatus(0);
		menu.setSecondName(secondName);
		menu.setThirdName(thirdName);
		if(!"".equals(thirdName)){
			name = new String(thirdName.getBytes("ISO-8859-1"), "utf-8");
			menu.setThirdName(thirdName);
		}
		menuService.insertMenu(menu);
		return "success";

	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String sucess() {
		return "success";
	}

	@RequestMapping(value = "/jsonMenu", method = RequestMethod.GET)
	@ResponseBody
	public List<Menu> queryMenu(int typeId) {
		List<Menu> menuList = menuService.queryMenuByType(typeId);
		return menuList;
	}

	@RequestMapping(value = "/queryMenu", method = RequestMethod.GET)
	@ResponseBody
	public List<Menu> queryMenuByStore(HttpServletRequest request) {
		int storeId=1;
		if(StringUtil.isNotBlank(request.getParameter("storeId"))){
		 storeId=Integer.valueOf(request.getParameter("storeId"));
		}
		int eatType=-1;
		if(StringUtil.isNotBlank(request.getParameter("eatType"))){
			eatType=Integer.valueOf(request.getParameter("eatType"));
			}
		List<Menu> menuList = menuService.queryMenuByStoreId(storeId,eatType);
		return menuList;
	}

	@RequestMapping(value = "/menulist", method = RequestMethod.GET)
	public String queryMenuList(ModelMap model) {
		int storeId = 1;
		List<Menu> menuList = menuService.queryMenuByStoreId(storeId,0);
		model.addAttribute("menuList", menuList);
		return "menulist";
	}

	/**
	 * 修改菜单
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/modifymenu", method = RequestMethod.GET)
	public String modifyMenu(Model model, int menuId) {
		Menu menu = menuService.modifyMenu(menuId);
		model.addAttribute("menu", menu);
		int storeId = 1;
		List<MenuType> list = menuTypeService.queryMenuList(storeId);
		model.addAttribute("list", list);
		return "modifymenu";
	}

	/**
	 * 执行 修改菜单
	 * 
	 * @param name
	 * @param price
	 * @param picUrl
	 * @param type
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/modifymenuaction", method = RequestMethod.GET)
	public String modifyMenu(String name, int price, String picUrl, int type,
			int id, String secondName, String thirdName,int eatType,
			HttpServletResponse response) throws IOException {
		Menu menu = new Menu();
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		menu.setId(id);
		menu.setName(name);
		menu.setPicUrl(picUrl);
		menu.setPrice(price);
		menu.setTypeId(type);
		menu.setSecondName(secondName);
		menu.setThirdName(thirdName);
		menu.setEatType(eatType);
		if(!"".equals(thirdName)){
			thirdName = new String(thirdName.getBytes("ISO-8859-1"), "utf-8");
			menu.setThirdName(thirdName);
		}
		menuService.modifMenuAction(menu);
		response.sendRedirect("menulist");
		return null;
	}

	@RequestMapping(value = "/deletemenu", method = RequestMethod.GET)
	public String deleteMenu(int id, int status, HttpServletResponse response)
			throws IOException {
		if (status == 0) {
			status = 1;
		} else {
			status = 0;
		}
		menuService.deleteMenu(id, status);
		response.sendRedirect("menulist");
		return null;
	}

	@RequestMapping(value = "/menu/importexcle", method = RequestMethod.GET)
	public String importmenu() {
		return "menu/importexcle";
	}
	
	@RequestMapping(value = "/menu/importExcel", method = RequestMethod.POST)
	public String getReadReport(@RequestParam("file") MultipartFile file)
			throws IOException, InvalidFormatException {
		poiService.readReport(file.getInputStream());
		return "success";

	}
	@RequestMapping(value = "/menu/uploadPic", method = RequestMethod.POST)
	public String getReadPic(@RequestParam("imgFile") MultipartFile file)
			throws IOException, InvalidFormatException {
		  // 获得文件：   
        // 获得文件名：   
        String fileName = file.getOriginalFilename();   
        // 获得输入流：   
        InputStream input = file.getInputStream();   
        //获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名  
        String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());  
        scpPicToServer(inputStream2String(input));
        //对扩展名进行小写转换  
        ext = ext.toLowerCase();  
        //File file = null;  
            try {  
               //imgFile.transferTo(file);                   //保存上传的文件  
           } catch (IllegalStateException e) {  
               e.printStackTrace();  
           }  
		return "success";

	}
	private  void scpPicToServer(String file){
		String user = "root";   
        String pass = "jckj2013";   
        String host = "121.199.22.111";   
        Connection con = new Connection(host);   
        try {   
            con.connect();   
            boolean isAuthed = con.authenticateWithPassword(user, pass);   
            System.out.println("isAuthed===="+isAuthed);   
               
               
          //  SCPClient scpClient = con.createSCPClient();   
            SCPClient scpClient=new SCPClient(con);
            //scpClient.put(remoteFile, length, remoteTargetDirectory, mode)
            scpClient.put(file,100000, "/var/www/html/1",null); //从本地复制文件到远程目录   
            Session session = con.openSession();   
            session.execCommand("uname -a && date && uptime && who");   //远程执行命令   
               
               
               
            //显示执行命令后的信息   
            System.out.println("Here is some information about the remote host:");   
            InputStream stdout = new StreamGobbler(session.getStdout());   
  
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));   
  
            while (true)   
            {   
                String line = br.readLine();   
                if (line == null)   
                    break;   
                System.out.println(line);   
            }   
  
            /* Show exit status, if available (otherwise "null") */  
  
            System.out.println("ExitCode: " + session.getExitStatus());   
  
            session.close();   
            con.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
	}
	public   String   inputStream2String   (InputStream   in)   throws   IOException   { 
        StringBuffer   out   =   new   StringBuffer(); 
        byte[]   b   =   new   byte[4096]; 
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   { 
                out.append(new   String(b,   0,   n)); 
        } 
        return   out.toString(); 
} 
}                           
