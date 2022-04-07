package ReBack.core.controller;

import ReBack.core.data.Category;
import ReBack.core.data.Design;
import ReBack.core.data.Material;
import ReBack.core.dto.DesignDTO;
import ReBack.core.service.CategoryService;
import ReBack.core.service.CategoryServiceImpl;
import ReBack.core.service.DesignServiceImpl;
import ReBack.core.service.MaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DesignController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private MaterialServiceImpl materialServiceImpl;

    @Autowired
    private DesignServiceImpl designServiceImpl;

    @PostMapping(value = "/design/addpost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addPost(
            @RequestParam(name = "designName")
                    String designName,
            @RequestParam(name = "designEx")
                    String designEx,
            @RequestParam(name = "category")
                    Long category,
            @RequestParam(name = "designImagePath")
                    MultipartFile designImagePath,
            @RequestParam(name = "designState")
                    boolean designState,
            @RequestParam(name = "material")
                    Long material,
            HttpServletRequest request
    ) throws IOException {
        System.out.println("designImagePath : " + designImagePath);
        String path = request.getSession().getServletContext().getRealPath("\\");
        String fileName = UUID.randomUUID() + designImagePath.getOriginalFilename();
        String pathName = path + "\\static\\images" + fileName;
        File file = new File(pathName);
        designImagePath.transferTo(file);

        Category findCategory = categoryServiceImpl.findCategoryId(category);

        Material findMaterial = materialServiceImpl.findMaterialId(material);

        System.out.println("designImagePath : " + designImagePath);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        Design inputDesign = new Design(designName, designEx, findCategory, fileName, localDateTime, designState, findMaterial);
        designServiceImpl.save(inputDesign);
        System.out.println("inputDesign : " + inputDesign);

        if (inputDesign != null) {
            return "<h2>디자인 등록이 완료되었습니다. </h2>"
                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/list\" />";
        } else {
            return "<h2>디자인 등록 실패. </h2>"
                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/addpost\" />";
        }
    }


//    @PostMapping(value = "/design/matching")
//    public String matching(
//            @RequestParam(name = "consultingPlace")
//                    String consultingPlace,
//            @RequestParam(name = "consultingStartingTime")
//                    String consultingStartingTime,
//            @RequestParam(name = "consultingEndTime")
//                    Long consultingEndTime,
//            HttpServletRequest request
//    ) throws IOException {
//        DesignDTO mathing = new DesignDTO(consultingPlace, consultingStartingTime, consultingEndTime);
//        designServiceImpl.save(inputDesign);
//        System.out.println("inputDesign : " + inputDesign);
//
//        if (inputDesign != null) {
//            return "<h2>디자인 등록이 완료되었습니다. </h2>"
//                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/list\" />";
//        } else {
//            return "<h2>디자인 등록 실패. </h2>"
//                    + "<meta http-equiv=\"refresh\" content=\"2;url=/design/addpost\" />";
//        }

    }