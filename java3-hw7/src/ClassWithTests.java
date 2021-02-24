public class ClassWithTests {

    @Test
    public static void test1() {
        System.out.println("Test 1 default priority");
    }

    @BeforeSuite
    public static void test2() {
        System.out.println("Test 2 BeforeSuite");
    }

    @Test(priority = 7)
    public static void test3() {
        System.out.println("Test 3, priority 7");
    }

    @Test(priority = 3)
    public static void test4() {
        System.out.println("Test 4 priority 3");
    }

    @Test
    public static void test5() {
        System.out.println("Test 5 default priority");
    }

    @AfterSuite
    public static void test7() {
        System.out.println("Test 7 AfterSuite");
    }
}
