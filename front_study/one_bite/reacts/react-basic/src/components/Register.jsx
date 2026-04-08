import {useState, useRef} from 'react'

const Register = () => {
    const [input, setInput] = useState({
        name: "",
        birth: "",
        country: "",
        introduce: "",
    });

    const countRef = useRef(0);
    const inputRef = useRef();
    const onClickRef = () => {
        countRef.current += 1; 
        console.log(countRef.current)
    }

    const onChange= (e) => {
        setInput({
            ...input,
            [e.target.name]: e.target.value,
        });
        countRef.current++;
    }

    const onSubmit = () => {
        if (input.name === "") {
            inputRef.current.focus();
            return;
        }
    }

        return (
            <div>
                <input placeholder={"이름"} onChange={onChange} name="name" ref={inputRef}/>{input.name}
                <br></br>
                <input placeholder={"생년월일"} type="date" onChange={onChange} name="birth" /> {input.birth}
                <br></br>
                <select placeholder={"국적"} onChange={onChange} name="country">
                    <option value="" hidden>국적을 선택해주세요</option>
                    <option value="KO">한국</option>
                    <option value="US">미국</option>
                    <option value="JP">일본</option>
                </select>{input.country}
                <br></br>
                <textarea placeholder={"자기소개"} onChange={onChange} name="introduce" />{input.introduce}
                <br></br>
                <button onClick={onSubmit}>회원가입</button>
                <br></br>
                <button onClick={onClickRef}>Ref 증가</button>
            </div>
        );
}

export default Register;