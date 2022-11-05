import java.util.Scanner;

public class SafeInputs {
    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt){
        int retVal = 0;
        String trash="";
        boolean done=false;

        do{
            System.out.println("\n" + prompt);
            if(pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine(); //Clear the buffer
                done = true;
            }else{
                trash=pipe.nextLine();
                System.out.println("You must enter an integer! You entered : " + trash);
            }
        }while(!done);
        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt){
        double retVal = 0;
        String trash="";
        boolean done=false;

        do{
            System.out.println("\n" + prompt);
            if(pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine(); //Clear the buffer
                done = true;
            }else{
                trash=pipe.nextLine();
                System.out.println("You must enter an integer! You entered : " + trash);
            }
        }while(!done);
        return retVal;
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int retVal = 0;
        String trash="";
        boolean done=false;

        do{
            System.out.println("\n" + prompt);
            if(pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine(); //Clear the buffer

                if(retVal >= low && retVal<=high){
                    done = true;
                }else{
                    System.out.println("\n The number is out of range [" +low + "-" + high +"]:" + retVal);
                }

            }else{
                trash=pipe.nextLine();
                System.out.println("You must enter an integer! You entered : " + trash);
            }
        }while(!done);
        return retVal;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double retVal = 0;
        String trash="";
        boolean done=false;

        do{
            System.out.println("\n" + prompt);
            if(pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine(); //Clear the buffer

                if(retVal >= low && retVal<=high){
                    done = true;
                }else{
                    System.out.println("\n The number is out of range [" +low + "-" + high +"]:" + retVal);
                }

            }else{
                trash=pipe.nextLine();
                System.out.println("You must enter an integer! You entered : " + trash);
            }
        }while(!done);
        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean retVal = false;
        boolean done = false;
        String answer = "";
        do{
            System.out.println("\n" + prompt);
            answer=pipe.nextLine();

            if(answer.equalsIgnoreCase("Y")){
                retVal = false;
                done = true;
            } else if (answer.equalsIgnoreCase("N")) {
                retVal=true;
                done = true;
            }else{
                System.out.println("\n You must answer Yes or no using [Y,y,N,n]. You answered: " + answer);
                System.out.println("Try again!");
            }

        }while(!done);
        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String retVal="";

        boolean done = false;

        do{
            System.out.println("\n" + prompt + ": ");
            retVal= pipe.nextLine();
            if(retVal.matches(regEx)){
                done=true;
            }else{
                System.out.println("\n" + retVal + " must match the pattern");
                System.out.println("Try again!");
            }
        }while(!done);
        return retVal;
    }
}
