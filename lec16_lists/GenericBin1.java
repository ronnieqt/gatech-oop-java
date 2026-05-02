public class GenericBin1<T>
{
    private T concent;

    public GenericBin1(T content)
    {
        this.concent = content;
    }

    public T getContent()
    {
        return concent;
    }

    public void setContent(T content)
    {
        this.concent = content;
    }

    public static void main(String[] args)
    {
        GenericBin1<String> test = new GenericBin1<>("I am a basic String");
        System.out.println(test.getContent());
        test.setContent("Short and stout");
        System.out.println(test.getContent().toUpperCase());
    }
}
