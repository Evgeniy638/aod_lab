import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите ФИО: ");
        String fullName = in.nextLine();

        startProgram(fullName);

//        test();
    }

    static void test() throws Exception {
        startProgram("Субботин Евгений Валерьевич");
//        startProgram("пупкин василий кириллович");
    }

    static void startProgram(String fullName) throws Exception {
        HashMap<NodeTree, Integer> map = getHashMapChar(fullName);

        NodeTree root = getRootTree(map);

        HashMap<Character, String> encoding = getEncoding(root);

        printEncoding(encoding);

        System.out.println("Закодированное ФИО: " + codeFullName(fullName, encoding));
    }

    static String codeFullName(String fullName, HashMap<Character, String> encoding) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < fullName.length(); i++) {
            res.append(encoding.get(fullName.charAt(i)));
        }

        return res.toString();
    }

    static void printEncoding(HashMap<Character, String> encoding) {
        for(Character c: encoding.keySet()) {
            System.out.println("Для буквы '" + c + "' - " + encoding.get(c));
        }
    }

    static HashMap<Character, String> getEncoding(NodeTree root) {
        HashMap<Character, String> map1 = getEncoding(root.left, "0");
        HashMap<Character, String> map2 = getEncoding(root.right, "1");

        HashMap<Character, String> map = new HashMap<>(map1);

        map2.forEach(map::put);

        return map;
    }

    static HashMap<Character, String> getEncoding(NodeTree node, String code) {
        if (node.left != null && node.right != null) {
            HashMap<Character, String> map1 = getEncoding(node.left, code + "0");
            HashMap<Character, String> map2 = getEncoding(node.right, code + "1");

            HashMap<Character, String> map = new HashMap<>(map1);

            map2.forEach(map::put);

            return map;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put(node.value, code);
        return map;
    }

    static NodeTree getRootTree(HashMap<NodeTree, Integer> map) throws Exception {
        //ищем два узла с минимальным значением
        Integer[] arr = map.values().toArray(new Integer[0]);
        Arrays.sort(arr);

        NodeTree minNode1 = getKeyByValue(arr[0], map);
        map.remove(minNode1);

        NodeTree minNode2 = getKeyByValue(arr[1], map);
        map.remove(minNode2);

        Integer newValue = arr[0] + arr[1];

        //добавляем новый узел в map
        map.put(new NodeTree(minNode1, minNode2), newValue);

        if (map.size() > 1) {
            return getRootTree(map);
        }

        return (NodeTree) map.keySet().toArray()[0];
    }

    static <K, V> K getKeyByValue(V value, HashMap<K, V> map) throws Exception {
        for(K key: map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }

        throw new Exception("Не верно указано значение " + value);
    }

    static HashMap<NodeTree, Integer> getHashMapChar(String fullName) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < fullName.length(); i++) {
            if (map.containsKey(fullName.charAt(i))) {
                map.replace(fullName.charAt(i), map.get(fullName.charAt(i)) + 1);
            } else {
                map.put(fullName.charAt(i), 1);
            }
        }

        HashMap<NodeTree, Integer> resultMap = new HashMap<>();

        for (Character c: map.keySet()) {
            resultMap.put(new NodeTree(c), map.get(c));
        }

        return resultMap;
    }
}
