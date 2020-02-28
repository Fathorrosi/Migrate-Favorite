package com.permata.migrate.web.rest;

import com.permata.migrate.entity.mysql.PermataFavorite;
import com.permata.migrate.service.mysql.MySqlPermataFavoriteService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PermataFavoriteResourcedb2 {

    @Autowired
    MySqlPermataFavoriteService mySqlPermataFavoriteService;

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
    @GetMapping(value ="/getYah")
    public void getAllPermataFavorite() {
//        List allPermataFavorite = (List) permataFavoriteService.getAllPermataFavorite();
        for(PermataFavorite permataFavorite : mySqlPermataFavoriteService.getAllPermataFavorite()) {
            System.out.println("GCN: " + permataFavorite.getGcn());

            System.out.println("================================");
        }
    }



//    @PostMapping(value = "/parameters")
//    public ResponseEntity<Object> creatParameter(@RequestBody @Valid PermataFavorite permataFavorite) throws URISyntaxException {
//        log.debug("REST request to save Parameter : {}", permataFavorite);
//        PermataFavorite result = (PermataFavorite) db2PermataFavoriteService.createPermataFavorite();
//        return ResponseEntity.created(new URI("/parameters/" + result.getTransactionType()))
//                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getActionx())).body(result);
//    }
//    public ResponseEntity<Object> getAllPermataFavorite(Pageable pageable) {
//        log.debug("REST request to get all permata favorite");
//        //Page<Parameter> page = parameterRepository.findAll(pageable);
//        List<PermataFavorite> page = permataFavoriteService.getAllPermataFavorite(pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/permataFavorite");
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }

}