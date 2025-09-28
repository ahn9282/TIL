package decorator_pattern.yc;

public class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text text) {
        this.decoratedText = text;
    }

    @Override
    public String getContent() {
        return decoratedText.getContent();
    }

    static class BoldDecorator extends TextDecorator {

        public BoldDecorator(Text text) {
            super(text);
        }

        @Override
        public String getContent(){
            return "<b>" + super.getContent() + "</b>";
        }
    }
    static class ItalicDecorator extends TextDecorator {

        public ItalicDecorator(Text text) {
            super(text);
        }

        @Override
        public String getContent(){
            return "<i>" + super.getContent() + "</i>";
        }
    }
    static class UnderlineDecorator extends TextDecorator {

        public UnderlineDecorator(Text text) {
            super(text);
        }

        @Override
        public String getContent(){
            return "<u>" + super.getContent() + "</u>";
        }
    }
}
