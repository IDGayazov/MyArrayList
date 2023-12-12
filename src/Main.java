public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 11; ++i){
            list.add(i);
        }

        System.out.println("list = " + list);

        list.add(2, 11);

        System.out.println("list.add(2, 11);");
        System.out.println("list = " + list);

        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 1; i < 3; ++i){
            list1.add(i);
        }

        System.out.println("list1 = " + list1);

        list.addAll(list1);

        System.out.println("list.addAll(list1);");
        System.out.println("list = " + list);

        System.out.println("list.remove(14)");
        System.out.println(list.remove(13));

        System.out.println("list = " + list);

        System.out.println("ArrayList.sort(list, (x, y) -> Integer.compare(x, y));");

        ArrayList.sort(list, (x, y) -> Integer.compare(x, y));

        System.out.println(list);

        ArrayList<Number> list2 = new ArrayList<>(list);
        System.out.println("ArrayList<Number> list2 = new ArrayList<>(list);");
        System.out.println(list2);
    }
}