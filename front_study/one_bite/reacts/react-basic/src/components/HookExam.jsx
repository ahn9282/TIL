import {useState} from 'react';

// 3가지 hook관련 팁
// 1. 함수 컴넌트, 커스텀 훅 내부에서만 호출 가능
// 2. 조건부 호출 불가능
// 3. 커스텀 훅 제작 가능
const HookExam = () => {

    const [input, onChange] = useInput();

    return (
        <div>
            <h1>Hook</h1>
            <input value={input} onChange={onChange}/>
        </div>
    );
}

function useInput() {
    const [input, setInput] = useState("");
    const onChange = (e) => {
        setInput(e.target.value);
        console.log(input); 
    }
    return [input, onChange];
}

export default HookExam;