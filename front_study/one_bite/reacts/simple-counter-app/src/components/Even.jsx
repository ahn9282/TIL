import {useEffect} from "react"

export const Even = () => {

    // 클린업, 정리함수
    useEffect (() => {
        return () => {
            console.log("unmount");
        };
    }, []);

    return (
        <div>짝수입니다.</div>
    )
}