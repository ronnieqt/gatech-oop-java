// Bounded Type Parameters in Generic:
// GenericBin1<T extends Insect>
// GenericBin1<T extends Comparable>
// GenericBin1<T extends Insect & Comparable & Groomable>

public class GenericBinCompare<T extends Comparable<T>>
{
    private T content1;
    private T content2;

    public GenericBinCompare(T content1, T content2)
    {
        this.content1 = content1;
        this.content2 = content2;
    }

    public T greaterValue()
    {
        return (content1.compareTo(content2) >= 0 ? content1 : content2);
    }

    public static void main(String[] args)
    {
        GenericBinCompare<String> test = new GenericBinCompare<>("basic string", "short and stout");
        System.out.println(test.greaterValue());
    }
}
