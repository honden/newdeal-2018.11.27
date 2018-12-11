package bitcamp.newdeal.lms;

public class Test {
  public void input(int num) {
    
    int[] array = new int[10];
    
    for(int i=0;i<array.length;i++){
        array[i]=i+1;         
    }
    for(int i=0;i<array.length*20;i++){
        int tem;
        int tem2 = (int)(Math.random()*9);
        tem = array[0];
        array[0] = array[tem2];
        array[tem2] = tem;
    }
    System.out.println("나온값");
    for(int i=0;i<num;i++){
        System.out.println(array[i]);
    }
    //정렬
    for(int j=0;j<num-1;j++){
        for(int i=0;i<num-1;i++){
            if(array[i]<array[i+1]){
                int t=array[i];
                array[i]=array[i+1];
                array[i+1]=t;    
            }
        }
    }
    System.out.println("정렬값");
    for(int i=0;i<num;i++){
    System.out.println(array[num-i-1]);
    }
    System.out.println("끝");
  }
}
