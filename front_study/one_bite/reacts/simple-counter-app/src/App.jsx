import './App.css'
import Viewer from './components/Viewer.jsx'
import Controller from './components/Controller.jsx'
import {useState} from "react";

function App() {

    const [count, setCount] = useState(0);

    const onClickBtn = function(value){
        setCount(count + value);
    }

    return (
        <div className="App">
            <h1>Simple Counter App</h1>
            <section>
                <Viewer count={count}/>
            </section>
            <section>
                <Controller onClickBtn={onClickBtn}/>
            </section>
        </div>
    )
}

export default App
