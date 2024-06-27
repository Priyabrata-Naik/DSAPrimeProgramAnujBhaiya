package a_dsaPrimeDoubtNPractice.general;

import java.util.Scanner;

public class IndividualScoreProblem {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int firstPerson = 0;
        int secondPerson = 0;
        int thirdPerson = 0;
        int fourthPerson = 0;
        int fifthPerson = 0;

        int timeForFirstPerson = 24;
        int timeForSecondPerson = 24;
        int timeForThirdPerson = 24;
        int timeForFourthPerson = 24;
        int timeForFifthPerson = 24;

        int timeTakenByFirstPerson = 0;
        int timeTakenBySecondPerson = 0;
        int timeTakenByThirdPerson = 0;
        int timeTakenByFourthPerson = 0;
        int timeTakenByFifthPerson = 0;

        boolean isFirstPerson = false;
        boolean isSecondPerson = false;
        boolean isThirdPerson = false;
        boolean isFourthPerson = false;
        boolean isFifthPerson = false;

        int operation;

        while(true){
            while(timeForFirstPerson >= 0 || timeForSecondPerson >= 0 || timeForThirdPerson >= 0
            || timeForFourthPerson >= 0 || timeForFifthPerson >= 0){
                System.out.println("Enter the Operation between 1 to 3:");
                operation = sc.nextInt();
                switch(operation){
                    case 1:
                        System.out.println("Enter the operation for which people:");
                        int person = sc.nextInt();
                        switch (person){
                            case 1:
                                isFirstPerson = true;
                                break;
                            case 2:
                                isSecondPerson = true;
                                break;
                            case 3:
                                isThirdPerson = true;
                                break;
                            case 4:
                                isFourthPerson = true;
                                break;
                            case 5:
                                isFifthPerson = true;
                                break;
                            default:
                                System.out.println("Enter a valid person:");
                                throw new Exception("Enter a valid people");
                        }
                        if(isFirstPerson){
                            firstPerson += 5;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFirstPerson = sc.nextInt();
                            timeForFirstPerson -= timeTakenByFirstPerson;
                            isFirstPerson = false;
                        }else if(isSecondPerson){
                            secondPerson += 5;
                            System.out.println("Enter time taken by this person");
                            timeTakenBySecondPerson = sc.nextInt();
                            timeForSecondPerson -= timeTakenBySecondPerson;
                            isSecondPerson = false;
                        }else if(isThirdPerson){
                            thirdPerson += 5;
                            System.out.println("Enter time taken by this person");
                            timeTakenByThirdPerson = sc.nextInt();
                            timeForThirdPerson -= timeTakenByThirdPerson;
                            isThirdPerson = false;
                        }else if(isFourthPerson){
                            fourthPerson += 5;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFourthPerson = sc.nextInt();
                            timeForFourthPerson -= timeTakenByFourthPerson;
                            isFourthPerson = false;
                        }else if(isFifthPerson){
                            fifthPerson += 5;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFifthPerson = sc.nextInt();
                            timeForFifthPerson -= timeTakenByFifthPerson;
                            isFifthPerson = false;
                        }
                    case 2:
                        System.out.println("Enter the operation for which people:");
                        person = sc.nextInt();
                        switch (person){
                            case 1:
                                isFirstPerson = true;
                                break;
                            case 2:
                                isSecondPerson = true;
                                break;
                            case 3:
                                isThirdPerson = true;
                                break;
                            case 4:
                                isFourthPerson = true;
                                break;
                            case 5:
                                isFifthPerson = true;
                                break;
                            default:
                                System.out.println("Enter a valid person:");
                                throw new Exception("Enter a valid people");
                        }
                        if(isFirstPerson){
                            firstPerson += 10;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFirstPerson = sc.nextInt();
                            timeForFirstPerson -= timeTakenByFirstPerson;
                            isFirstPerson = false;
                        }else if(isSecondPerson){
                            secondPerson += 10;
                            System.out.println("Enter time taken by this person");
                            timeTakenBySecondPerson = sc.nextInt();
                            timeForSecondPerson -= timeTakenBySecondPerson;
                            isSecondPerson = false;
                        }else if(isThirdPerson){
                            thirdPerson += 10;
                            System.out.println("Enter time taken by this person");
                            timeTakenByThirdPerson = sc.nextInt();
                            timeForThirdPerson -= timeTakenByThirdPerson;
                            isThirdPerson = false;
                        }else if(isFourthPerson){
                            fourthPerson += 10;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFourthPerson = sc.nextInt();
                            timeForFourthPerson -= timeTakenByFourthPerson;
                            isFourthPerson = false;
                        }else if(isFifthPerson){
                            fifthPerson += 10;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFifthPerson = sc.nextInt();
                            timeForFifthPerson -= timeTakenByFifthPerson;
                            isFifthPerson = false;
                        }
                    case 3:
                        System.out.println("Enter the operation for which people:");
                        person = sc.nextInt();
                        switch (person){
                            case 1:
                                isFirstPerson = true;
                                break;
                            case 2:
                                isSecondPerson = true;
                                break;
                            case 3:
                                isThirdPerson = true;
                                break;
                            case 4:
                                isFourthPerson = true;
                                break;
                            case 5:
                                isFifthPerson = true;
                                break;
                            default:
                                System.out.println("Enter a valid person:");
                                throw new Exception("Enter a valid people");
                        }
                        if(isFirstPerson){
                            firstPerson += 15;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFirstPerson = sc.nextInt();
                            timeForFirstPerson -= timeTakenByFirstPerson;
                            isFirstPerson = false;
                        }else if(isSecondPerson){
                            secondPerson += 15;
                            System.out.println("Enter time taken by this person");
                            timeTakenBySecondPerson = sc.nextInt();
                            timeForSecondPerson -= timeTakenBySecondPerson;
                            isSecondPerson = false;
                        }else if(isThirdPerson){
                            thirdPerson += 15;
                            System.out.println("Enter time taken by this person");
                            timeTakenByThirdPerson = sc.nextInt();
                            timeForThirdPerson -= timeTakenByThirdPerson;
                            isThirdPerson = false;
                        }else if(isFourthPerson){
                            fourthPerson += 15;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFourthPerson = sc.nextInt();
                            timeForFourthPerson -= timeTakenByFourthPerson;
                            isFourthPerson = false;
                        }else if(isFifthPerson){
                            fifthPerson += 15;
                            System.out.println("Enter time taken by this person");
                            timeTakenByFifthPerson = sc.nextInt();
                            timeForFifthPerson -= timeTakenByFifthPerson;
                            isFifthPerson = false;
                        }
                    default:
                        System.out.println();
                }

            }
            if(timeForFirstPerson <= 0){
                System.out.println(firstPerson);
            }else if(timeForSecondPerson <= 0){
                System.out.println(secondPerson);
            }else if(timeForThirdPerson <= 0){
                System.out.println(thirdPerson);
            }else if(timeForFourthPerson <= 0){
                System.out.println(fourthPerson);
            }else if(timeForFifthPerson <= 0){
                System.out.println(fifthPerson);
            }

            if(timeForFirstPerson <= 0 || timeForSecondPerson <= 0 || timeForThirdPerson <= 0 ||
            timeForFourthPerson <= 0 || timeForFifthPerson <= 0){
                break;
            }

        }

    }
}
