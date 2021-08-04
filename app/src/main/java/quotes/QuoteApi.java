package quotes;

// for lab 09
public class QuoteApi {
    String quoteText;
    String quoteAuthor;
    String senderName;
    String senderLink;
    String quoteLink;

    public QuoteApi(String quoteText, String quoteAuthor, String senderName, String senderLink, String quoteLink) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.senderName = senderName;
        this.senderLink = senderLink;
        this.quoteLink = quoteLink;
    }

    @Override
    public String toString() {
        return "Quotes{" + "quoteText='" + quoteText + '\'' + ", quoteAuthor='" + quoteAuthor + '\'' + ", " +
                "senderName='" + senderName + '\'' + ", senderLink='" + senderLink + '\'' + ", quoteLink='" + quoteLink + '\'' + '}';
    }
}
