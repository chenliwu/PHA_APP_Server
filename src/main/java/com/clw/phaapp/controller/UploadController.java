package com.clw.phaapp.controller;

import com.clw.phaapp.common.entity.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 上传文件
 * Created by LXP on 2017/8/9.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    private final String BASE_DIR="fileUpload";
    private final String IMG_DIR = "images";

    /**
     * 上传图片文件
     * 文件将会存放在target下的PHA_APP_Server/fileUpload/images/
     * @param multipartFile
     * @param request
     * @return
     */
    @RequestMapping("/img")
    @ResponseBody
    public ResultEntity uploadImg(@RequestParam("imgFile")MultipartFile multipartFile, HttpServletRequest request){
        ResultEntity resultEntity = new ResultEntity();
        if(!multipartFile.isEmpty()){
            System.out.println("上传图片文件："+multipartFile.toString());
            //文件上传的目录，目录在target下的UploadFileServerDemo/fileUpload/images/
            String path = request.getServletContext().getRealPath("/");
            File dir = new File(path,BASE_DIR+"/"+IMG_DIR);
            if(!dir.exists()){
                boolean mkdirs = dir.mkdirs();
                if(!mkdirs){
                    throw new IllegalArgumentException();
                }
            }
            //文件后缀名
            String suffix = getSuffix(multipartFile.getOriginalFilename());
            //文件名
            String imgName = UUID.randomUUID().toString()+(suffix != null?suffix:".jpg");
            //初始化文件对象
            File imgFile = new File(dir,imgName);
            try {
                //创建文件对象并保存到磁盘当中
                imgFile.createNewFile();
                multipartFile.transferTo(imgFile);
                resultEntity.setState(200);
                resultEntity.setData(request.getServletContext().getContextPath()
                        +"/"+BASE_DIR+"/"+IMG_DIR+"/"+imgName);
            } catch (IOException e) {
                resultEntity.setMessage("上传图片失败");
            }
            return resultEntity;
        }else{
            resultEntity.setMessage("没有找到文件");
            return resultEntity;
        }
    }


    /**
     * 保存文件
     * @param multipartFile
     * @param request
     */
    private void saveFile(MultipartFile multipartFile,HttpServletRequest request){

    }

    /**
     * 获取后缀名
     * @param name
     * @return
     */
    private String getSuffix(String name){
        if(name == null){
            return null;
        }
        int index = name.lastIndexOf('.');
        if(index == -1){
            return null;
        }
        return name.substring(index);
    }



    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath(BASE_DIR)
                +"/"+IMG_DIR+"/"+"4d399a82-5a13-47fb-9e46-7ae8723fa111.jpg";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "4d399a82-5a13-47fb-9e46-7ae8723fa111.jpg";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }


    /**
     * 下载文件
     *  如果方法设置了返回值，则需要 @ResponseBody来修饰方法。
     *  如果方法不设置返回，则设为void。
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    @ResponseBody
    public ResultEntity download(String fileName, HttpServletRequest request,
                           HttpServletResponse response) {
        ResultEntity resultEntity=new ResultEntity();
        if(fileName == null || fileName.length() == 0){
            resultEntity.setMessage("没有"+fileName+"这个文件");
            return resultEntity;
        }

        try {
            //存放文件路径
            //错误的路径：PHA_APP_Server\target\PHA_APP_Server\images\8792a695-28f3-42a8-8c27-c16cc03f6e8c.jpg
           // String path = request.getSession().getServletContext().getRealPath
           //         ("images")+File.separator+;
            String path = request.getSession().getServletContext().getRealPath(BASE_DIR)
                    +"\\"+IMG_DIR+"\\";
            File file = new File(path+fileName);
            if(file.exists()){
                //文件存在
                System.out.println("文件存在："+path+fileName);

                //设置相应的编码格式和ContentType类型，这样设置，会自动判断下载文件类型
                response.setCharacterEncoding("utf-8");
                response.setContentType("multipart/form-data");
                response.setHeader("Content-Disposition", "attachment;fileName="
                        + fileName);

                InputStream inputStream = new FileInputStream(file);
                OutputStream os = response.getOutputStream();
                byte[] b = new byte[2048];
                int length;
                while ((length = inputStream.read(b)) > 0) {
                    os.write(b, 0, length);
                }

                // 这里主要关闭。
                os.close();
                inputStream.close();
                resultEntity.setState(200);
                resultEntity.setMessage("下载文件"+fileName+"成功");
            }else{
                //文件不存在
                System.out.println("文件不存在："+path+fileName);
                resultEntity.setMessage("文件"+fileName+"不存在");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            resultEntity.setMessage("没有"+fileName+"这个文件");
           // return resultEntity;
        } catch (IOException e) {
            e.printStackTrace();
            resultEntity.setMessage("下载文件"+fileName+"失败");
           // return resultEntity;
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return resultEntity;
    }




}
