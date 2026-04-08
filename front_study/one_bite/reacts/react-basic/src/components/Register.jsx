import {useState} from 'react'
//간단한 회원 가입 폼
// 1. 이름
// 2. 생년월일
// 3. 국적
// 4. 자기소개

const Register = () => {
    const [name, setName] = useState("");
    const [country, setCountry] = useState("");
    const [birth, setBirthDate] = useState("");
    const [introduce, setIntroduce] = useState("");
    
    const onChangeName = (e) =>{
        setName(e.target.value);
        console.log(e);
    }
    
    const onChangeBirthDate = (e) =>{
        setBirthDate(e.target.value);
        console.log(e);
    }  
    
    const onChangeCountry = (e) =>{
        setCountry(e.target.value);
        console.log(e);
    }

    const onChangeIntroduce = (e) =>{
        setIntroduce(e.target.value);
        console.log(e);
    }

        return (
            <div>
                <input placeholder={"이름"} onChange={onChangeName}/>{name}
                <br></br>
                <input placeholder={"생년월일"} type="date" onChange={onChangeBirthDate} /> {birth}
                <br></br>
                <select placeholder={"국적"} onChange={onChangeCountry}>
                    <option value="" hidden>국적을 선택해주세요</option>
                    <option value="KO">한국</option>
                    <option value="US">미국</option>
                    <option value="JP">일본</option>
                </select>{country}
                <br></br>
                <textarea placeholder={"자기소개"} onChange={onChangeIntroduce} />{introduce}
                <br></br>
                <button onClick={() => {console.log(name, birth, country, introduce)}}>회원가입</button>
            </div>
        );
}

export default Register;