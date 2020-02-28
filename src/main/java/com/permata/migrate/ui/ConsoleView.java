package com.permata.migrate.ui;

import com.permata.migrate.service.PermataAliasAccountService;
import com.permata.migrate.service.PermataFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by HP on 31/10/2019.
 */
@Component
public class ConsoleView implements CommandLineRunner {
    int optionAction;
    int optionSetProcessLimit;
    int optionStartProcess;
    int optionMigration;

    int dataProcessLimit = 10000;

    //int data;
    int table;

    @Autowired
    PermataFavoriteService permataFavoriteService;
    @Autowired
    PermataAliasAccountService permataAliasAccountService;

    public ConsoleView() {

    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.print("command line runner");
        do {
            Scanner input = new Scanner(System.in);

            System.out.println("--------------");
            System.out.println("DATA MIGRATION");
            System.out.println("--------------");
            System.out.println("Chose from this Choices :");
            System.out.println("1. Migration");
            System.out.println("2. Exit\n");

            System.out.print("Your Selection : ");
            optionAction = input.nextInt();
            System.out.println();

            switch (optionAction) {
                case 1:

                    do {
                        System.out.println("\nChoose Migration : ");
                        System.out.println("1. Permata Favorite ");
                        System.out.println("2. Permata Alias Account");
                        System.out.println("3. Back \n");

                        System.out.print("Your Selection : ");
                        optionMigration = input.nextInt();

                        switch (optionMigration) {
                            case 1:
                                do {
                                    System.out.println("1. start ");
                                    System.out.println("2. Back\n");

                                    System.out.print("Your Selection : ");
                                    optionStartProcess = input.nextInt();

                                    switch (optionStartProcess) {
                                        case 1:
                                            //SpringApplication.run(Db2toMySqlApplication.class, args);
                                            runMigrationOption(optionMigration, dataProcessLimit);
                                            optionSetProcessLimit = 2;
                                            optionStartProcess = 2;
                                            optionMigration = 3;
                                            break;
                                        case 2:
                                            optionStartProcess = 2;
                                            break;
                                        default:
                                            System.out.println("Invalid selection\n");
                                            break; // This break is not really necessary

                                    }
                                } while (optionStartProcess != 2);
                                break;

                            case 2:

                                do {
                                    System.out.println("1. start ");
                                    System.out.println("2. Back\n");

                                    System.out.print("Your Selection : ");
                                    optionStartProcess = input.nextInt();

                                    switch (optionStartProcess) {
                                        case 1:
                                            //SpringApplication.run(Db2toMySqlApplication.class, args);
                                            runMigrationOption(optionMigration, dataProcessLimit);
                                            optionSetProcessLimit = 2;
                                            optionStartProcess = 2;
                                            optionMigration = 3;
                                            break;
                                        case 2:
                                            optionStartProcess = 2;
                                            break;
                                        default:
                                            System.out.println("Invalid selection\n");
                                            break; // This break is not really necessary

                                    }
                                } while (optionStartProcess != 2);
                                break;

                            default:
                                System.out.println("Invalid selection\n");
                                break; // This
                        }

                    } while (optionMigration != 3);

                    break;
                case 2:
                    System.out.println("Thank You\n");
                    break;
                default:
                    System.out.println("Invalid selection\n");
                    break; // This break is not really necessary
            }

        } while (optionAction != 2);


    }

    private void runMigrationOption(int option, int data) {
//        System.out.println(option);
        if (option == 1) {
            permataFavoriteService.dataMigrationPermataFavorite(data);
            //dataMigrationPermataFavorite(data);
        } else {
            permataAliasAccountService.dataMigrationPermataAliasAccount(data);
            //dataMigrationPermataAliasAccount(data);
        }

//        permataAliasAccountService.inpuDataPermataAliasAccount();
    }

}
