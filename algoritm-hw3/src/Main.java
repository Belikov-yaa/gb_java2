public class Main {
    public static void main(String[] args) {
//        MyStack<String> myStack = new MyStack<>();
//
//        myStack.push("asd");
//        myStack.push("bnm");
//        myStack.push("cdfg");
//        myStack.push("dffghfghfg");
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(myStack.pop());
//        }

//        Expression expression = new Expression("(( [7] + {-8*a} + t ])");
//        System.out.println(expression.checkBracket());

//        MyQueue<Integer> myQueue = new MyQueue<>();
//        for (int i = 0; i < 5; i++) {
//            myQueue.insert(i*10);
//        }
//        System.out.println(myQueue);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.print(myQueue.remove());
//        }
//        System.out.println(myQueue);

        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>();
        mpq.insert(5);
        mpq.insert(1);
        mpq.insert(3);
        mpq.insert(4);
        mpq.insert(7);
        mpq.insert(2);

        System.out.println(mpq);
        System.out.println(mpq.remove());
        System.out.println(mpq);
        mpq.insert(6);
        System.out.println(mpq);
    }
}
