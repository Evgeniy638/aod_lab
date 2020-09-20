import java.util.ArrayList;

public class AVLTree {
    private class Element {
        protected Element left;
        protected Element right;
        protected int value;

        protected int height;

        Element(int value) {
            this(null, null, value);
        }

        public Element(Element left, Element right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.height = 1;
        }
    }

    private Element root;

    public AVLTree (int[] arr) {
        this.root = new Element(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            this.add(arr[i]);
        }
    }

    public void add(int value) {
        this.root = add(this.root, value);
    }


    public void delete(int value) {
        this.root = delete(this.root, value);
    }


    //вставка ключа value в дерево с корнем p
    private Element add(Element p, int value) {
        if (p == null) {
            return new Element(value);
        }

        if (value < p.value) {
            p.left = add(p.left, value);
        } else {
            p.right = add(p.right, value);
        }

        return balance(p);
    }

    //удаляем узел с ключом value из дерева p
    private Element delete(Element p, int value) {
        if (p == null) return null;

        if (value < p.value) {
            p.left = delete(p.left, value);
        } else if (value > p.value) {
            p.right = delete(p.right, value);
        } else {
            Element left = p.left;
            Element right = p.right;

            if (right == null) return left;

            Element min = findMin(right);
            min.right = removeMin(right);
            min.left = left;

            return balance(min);
        }

        return balance(p);
    }

    //удаление узла с минимальным ключом из дерева p
    private Element removeMin(Element p){
        if (p.left == null) {
            return p.right;
        }

        p.left = removeMin(p.left);

        return balance(p);
    }

    //поиск узла с минимальным ключом в дереве p
    private Element findMin(Element p) {
        return p.left != null ?findMin(p.left) :p;
    }

    //балансировка узла p
    private Element balance(Element p) {
        fixHeight(p);

        if (calcBalanceFactor(p) == 2) {
            if (calcBalanceFactor(p.right) < 0) {
                p.right = rotateRight(p.right);
            }

            return rotateLeft(p);
        }

        if (calcBalanceFactor(p) == -2) {
            if (calcBalanceFactor(p.left) > 0) {
                p.left = rotateLeft(p.left);
            }

            return rotateRight(p);
        }

        return p;
    }

    //правый поворот вокруг p
    private Element rotateRight(Element p) {
        Element q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    //левый поворот вокруг q
    private Element rotateLeft(Element q) {
        Element p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    private int getHeight(Element element){
        return element != null ?element.height :0;
    }

    private int calcBalanceFactor(Element element) {
        return getHeight(element.right) - getHeight(element.left);
    }

    private void fixHeight(Element element) {
        int hl = getHeight(element.left);
        int hr = getHeight(element.right);
        element.height = Math.max(hl, hr) + 1;
    }

    public void printTree() {
        print(this.root);
    }

    private void print(Element p){
        if (p.left != null) {
            System.out.println(p.value + "->" + p.left.value);
            print(p.left);
        }

        if (p.right != null) {
            System.out.println(p.value + "->" + p.right.value);
            print(p.right);
        }
    }

    public int[] getArr() {
        return getArr(this.root);
    }

    private int[] getArr(Element p) {
        int[] arrLeft = new int[0];
        int[] arrRight = new int[0];

        if (p.left != null) {
            arrLeft = getArr(p.left);
        }

        if (p.right != null) {
            arrRight = getArr(p.right);
        }

        int[] arrResult = new int[arrRight.length + arrLeft.length + 1];

        System.arraycopy(arrLeft, 0, arrResult, 0, arrLeft.length);

        arrResult[arrLeft.length] = p.value;

        for (int i = 0; i < arrRight.length; i++) {
            arrResult[arrLeft.length + 1 + i] = arrRight[i];
        }

        return arrResult;
    }
}
