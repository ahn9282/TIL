import {useState} from 'react'

const Counter = () => {
    const [count, setCount] = useState(0);
    return <div>
            <h1>State: {count}</h1>
            <button
                onClick={() => {
                // 비동기 업데이트를 고려한 함수형 업데이트 권장
                setCount((prev) => prev + 1);
                // 여기서 console.log(count) 하면 이전 값이 나옵니다. 정상입니다.
                }}
            >
                +
            </button>
        </div>
}

export default Counter;