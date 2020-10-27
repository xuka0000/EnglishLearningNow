
public  class logic extends Thread {

   word[] WordDate = date.WordDate_2016;
   //测试代码
   //已测试单词数
   public int fightNum = 0;
   //是否确定单词库 and 是否学完单词库
   public boolean isNewData = true;
   //随机数
   public int Random ;
   //是否已经测试过了
   public boolean[] visited = new boolean[300];
   //是否需要进行下一个单词了
   public boolean change = true;
   //是否做对
   public boolean congratulation = false;
   //是否作答
   public boolean isAnswer = false;
   //A-B-C-D四个选项
   public  Choice[] choice = {
           new Choice(null,false),
           new Choice(null,false),
           new Choice(null,false),
           new Choice(null,false),
   };

   Grame gf;

   public logic (Grame gf){
      WordDate = date.WordDate_2016;
      this.gf = gf;
   }

   public void run(){
      //先把所有单词置为全为认识
      for(int i = 0 ; i <visited.length ; i++){
         this.visited[i] = false;

      }

      //死循环中

      while(true){
        // System.out.println(change);
         //判断词库里有没有单词
         if(fightNum >= WordDate.length){
            isNewData = true;
            fightNum = 0;
            for(int i=0 ; i<visited.length ; i++){
               visited[i] = false;
            }
         }
         while(change && isNewData == false){
            //进来就让change变成false不让它出去
            congratulation = false;
            isAnswer = false;
            change = false;
            //将四个选项重置一下

            for(int i = 0 ; i<4 ; i++){
                  choice[i].isRight = false;
            }

            //确定单词
            int tempRandom;
             do{
                 tempRandom = (int)(Math.random()*this.WordDate.length/1);
                // System.out.println(tempRandom);
             }while(visited[tempRandom] == true);
             Random = tempRandom;
           // System.out.println(change);System.out.println(Random);
             //确定正确选项是A-B-C-D
            int rightChoice=randomInFour();

               choice[rightChoice].isRight = true;
               choice[rightChoice].word = WordDate[Random];


            //确定错误选项
            int[] wrongChoice = new int[3];
            wrongChoice = randomInLength(rightChoice);

            //将错误选项填入choice 数组中
            int wrong = 0;
            for(int i = 0 ; i<4 ; i++){
               if(i!=rightChoice){

                     choice[i].word = WordDate[wrongChoice[wrong]];
                     wrong++;

               }
            }

         }

         try {
            Thread.sleep(200);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }


   /*合并正确错误选项*/
   public void SetRound(int correctNum){
      //确定A选项是正确答案
      int A = randomInFour();
      //找到其他三个错误选项
       int[] wrong = randomInLength(correctNum);


   }

   /*确定单其他三个错误选项*/
   public  int[] randomInLength(int correct){
      int A ,B, C;
      do{
         A = (int)(Math.random()*WordDate.length/1);
      }while(A==correct);
      do{
         B = (int)(Math.random()*WordDate.length/1);
      }while(B==correct || B==A);
      do{
         C = (int)(Math.random()*WordDate.length/1);
      }while(C==correct || C==B || C==A);

       int[] option ={A,B,C};
       return option;
   }

   //确定单词是哪一个选项目前单词（4选1）
   public  int randomInFour(){
      int option = (int)(Math.random()*4/1);
      return option;
   }
}
