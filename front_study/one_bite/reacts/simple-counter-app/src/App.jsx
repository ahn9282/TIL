import './App.css'
import Viewer from './components/Viewer.jsx'
import Controller from './components/Controller.jsx'
import {useState, useEffect, useRef} from "react";
import {Even} from "./components/Even.jsx";

function App() {

    const [count, setCount] = useState(0);
    const [input, setInput] = useState("");

    const isMount = useRef(false);

    // 1. 마운트 : 탄생
    useEffect (() => {
        console.log("mount");
    }, []);
    // 2.  업데이트 : 변화, 리 렌더링
    useEffect (() => {
        if(! isMount.current){
            isMount.current = true;
            return;
        }
        console.log("update");
    });
    // 3. 언마운트 : 죽음


    useEffect(
        () => {console.log("change effect - count : " + count + ", input : " + input)}
        , [count, input]);

    const onClickBtn = function(value){
        setCount(count + value);
    }

    return (
        <div className="App">
            <h1>Simple Counter App</h1>
            <section>
                <input value={input} onChange={(e) => {setInput(e.target.value)}}/>
            </section>
            <section>
                <Viewer count={count}/>
                {count % 2 === 0 ? <Even/> : null}
            </section>
            <section>
                <Controller onClickBtn={onClickBtn}/>
            </section>
        </div>
    )
}

export default App
