import {useState} from 'react'
//간단한 회원 가입 폼
// 1. 이름
// 2. 생년월일
// 3. 국적
// 4. 자기소개

const Register = () => {
    const [input, setInput] = useState({
        name: "",
        birth: "",
        country: "",
        introduce: "",
    });

    const onChange= (e) => {
        setInput({
            ...input,
            [e.target.name]: e.target.value,
        });
    }

        return (
            <div>
                <input placeholder={"이름"} onChange={onChange} name="name"/>{input.name}
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
                <button onClick={() => {console.log(input)}}>회원가입</button>
            </div>
        );
}

export default Register;