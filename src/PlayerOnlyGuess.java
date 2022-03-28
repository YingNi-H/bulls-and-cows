public class PlayerOnlyGuess {
    protected int[] computerSecreteNumber;
    protected int[] playerGuess;
    protected String eachResult;
    protected String finalResult;

    

    public String compare(int[]computerSecreteNumber,int[]playerGuess){
        computerSecreteNumber= new int[4];
        for (int i = 0; i < 4; i++) {
            computerSecreteNumber[i]= (int)(Math.random()*10);
            System.out.println(computerSecreteNumber[0]+computerSecreteNumber[1]+computerSecreteNumber[2]+computerSecreteNumber[3]);
        }



        return null;
    }

    public String getEachResult(){return eachResult;}

    public String getFinalResult() {
        return finalResult;
    }
}
