package ab_questionInCourse.dsaArray;

public class FindTwoRectanglesIfOverlap {
    public static void main(String[] args) {



    }
    static boolean isRectangleOverlap(int rec1[], int rec2[]){
        int firstRecLowerLeftX= rec1[0],firstRecLowerLeftY=rec1[1];
        int firstRecUpperRightX=rec1[2],firstRecUpperRightY=rec1[3];

        int secRecLowerLeftX =rec2[0],secRecLowerLeftY=rec2[1];
        int secRecUpperRightX =rec2[2],secRecUpperRightY=rec2[3];


        if(firstRecLowerLeftX==firstRecUpperRightX || firstRecLowerLeftY==firstRecUpperRightY ||
                secRecLowerLeftX==secRecUpperRightX || secRecLowerLeftY==secRecUpperRightY){
            return false;
        }
        else if(secRecLowerLeftY>firstRecUpperRightY || firstRecLowerLeftY>secRecUpperRightY){
            return false;
        }
        else if(secRecLowerLeftX>firstRecUpperRightX || firstRecLowerLeftX>secRecUpperRightX){
            return false;
        }
        else{
            return true;
        }

    }
}
