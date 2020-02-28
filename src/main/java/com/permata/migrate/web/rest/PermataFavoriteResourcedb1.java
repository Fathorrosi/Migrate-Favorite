package com.permata.migrate.web.rest;

import com.permata.migrate.entity.db2.PermataFavorite;
import com.permata.migrate.service.db2.DB2PermataFavoriteService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PermataFavoriteResourcedb1 {

    @Autowired
    DB2PermataFavoriteService DB2PermataFavoriteService;

    private static final String ENTITY_NAME = "PermataFavorite";

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    //
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping
    public void getAllPermataFavorite() {
//        System.out.printf("aaaaaaaaaaaaaaaaaaaaaaaaa");
//        List allPermataFavorite = (List) permataFavoriteService.getAllPermataFavorite();

//        System.out.println(taskService.getAllTask());
        for(PermataFavorite permataFavorite : DB2PermataFavoriteService.getAllPermataFavorite()) {
            System.out.println("Action: " + permataFavorite.getTransactionType());

            System.out.println("================================");
        }

//        System.out.println(taskService.getAllTask());
    }
//    public ResponseEntity<Object> getAllPermataFavorite(Pageable pageable) {
//        log.debug("REST request to get all permata favorite");
//        //Page<Parameter> page = parameterRepository.findAll(pageable);
//        List<PermataFavorite> page = permataFavoriteService.getAllPermataFavorite(pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/permataFavorite");
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }

}