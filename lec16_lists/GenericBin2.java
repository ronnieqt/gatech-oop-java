public class GenericBin2<T1, T2>
{
    private T1 content1;
    private T2 content2;

    public GenericBin2(T1 content1, T2 content2)
    {
        this.content1 = content1;
        this.content2 = content2;
    }

    public T1 getContent1()
    {
        return content1;
    }

    void setContent1(T1 content1)
    {
        this.content1 = content1;
    }

    public T2 getContent2()
    {
        return content2;
    }

    void setContent2(T2 content2)
    {
        this.content2 = content2;
    }

    public static void main(String[] args)
    {
        GenericBin2<String, Integer> test = new GenericBin2<>("Hello", 42);
        System.out.println(test.getContent1() + ", " + test.getContent2());
    }
}
