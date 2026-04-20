import './Editor.css';
import {useState, useRef, useContext} from "react";
import { TodoFuncContext} from "../App"

const Editor = () => {

    const {onCreate} = useContext(TodoFuncContext);
    const [content, setContent] = useState("");
    const contentRef = useRef();

    const onChangeContent = function(e) {
        setContent(e.target.value);
    }

    const onKeyDown = function(e) {
        if (e.keyCode === 13){
            onSubmit();
        }
    }

    const onSubmit = function() {
        if (content === "") {
            contentRef.current.focus();
            return;
        }
        onCreate(content);
        setContent("");
    }

    return (
        <section className='Editor'>
            <input
                ref={contentRef}
                onKeyDown={onKeyDown}
                value={content}
                onChange={onChangeContent}
                placeholder="새로운 Todo..."
            />
            <button onClick={onSubmit}>추가</button>
        </section>
    )
}
export default Editor;