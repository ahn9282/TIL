import {useReducer} from "react";

// Reducer : 변환기
// -> 상태를 실제로 변화시키는 변환기 역할
const reducer = function(state, action) {
    console.log(state, action);
    if (action.type === "INCREASE") return state + action.data;
    if (action.type === "DECREASE") return state - action.data;
    return state;
}
const Exam = () => {

    const [state, dispatch] = useReducer(reducer, 0);

    const callDispatch = function(type, data) {
        return dispatch({
            type: type,
            data: data
        })
    }

    //인수 : 상태가 어떻게 변화되길 원하는지
    // -> 액션 객체
    const onClickPlus = function(){
        callDispatch("INCREASE", 1);
    }
    const onClickMinus = function(){
        callDispatch("DECREASE", 1);
    }

    return (
        <div>
            <h1>{state}</h1>
            <button onClick={onClickPlus}>+</button>
            <button onClick={onClickMinus}>-</button>
        </div>
    )
}
 export default Exam;