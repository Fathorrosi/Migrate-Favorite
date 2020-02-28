//package com.permata.migrate.web.rest;
//
//import com.permata.migrate.entity.db2.Tasks;
//import com.permata.migrate.service.db2.TaskService;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class TaskResource {
//
//    @Autowired
//    TaskService taskService ;
//
//    private static final String ENTITY_NAME = "Task";
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//    //
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
//                    value = "Results page you want to retrieve (0..N)"),
//            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
//                    value = "Number of records per page."),
//            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
//                    value = "Sorting criteria in the format: property(,asc|desc). " +
//                            "Default sort order is ascending. " +
//                            "Multiple sort criteria are supported.")
//    })
//    @GetMapping(value = "/task")
//    public void getAllTasks() {
////        System.out.printf("aaaaaaaaaaaaaaaaaaaaaaaaa");
////        List allPermataFavorite = (List) permataFavoriteService.getAllPermataFavorite();
//
////        System.out.println(taskService.getAllTask());
//        for(Tasks tasks : taskService.getAllTask()) {
//            System.out.println("GCN: " + tasks.getDescription());
//
//            System.out.println("================================");
//        }
//
////        System.out.println(taskService.getAllTask());
//    }
////    public ResponseEntity<Object> getAllPermataFavorite(Pageable pageable) {
////        log.debug("REST request to get all permata favorite");
////        //Page<Parameter> page = parameterRepository.findAll(pageable);
////        List<PermataFavorite> page = permataFavoriteService.getAllPermataFavorite(pageable);
////        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/permataFavorite");
////        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
////    }
//
//}