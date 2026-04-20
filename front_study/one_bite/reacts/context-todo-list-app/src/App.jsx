import './App.css'
import Header from "./components/Header.jsx";
import Editor from "./components/Editor.jsx";
import List from "./components/List.jsx";
import {createContext, useCallback, useMemo, useReducer, useRef} from "react";
import Exam from "./components/Exam.jsx";

const createMockData = function (id, isDone, content, date) {
    return {
        id: id,
        isDone: isDone,
        content: content,
        date: date
    };
}

const reduce = function (state, action) {
    switch (action.type) {
        case "CREATE":
            return [...state, action.data];
        case "UPDATE":
            return state.map((item) => {
                if (item.id === action.data) {
                    return {...item, isDone: !item.isDone}
                }
                return item
            })
        case "DELETE":
            return state.filter((item) => item.id !== action.data);
        default:
            return state;
    }
}

// eslint-disable-next-line react-refresh/only-export-components
export const TodoStateContext = createContext();
// eslint-disable-next-line react-refresh/only-export-components
export const TodoFuncContext = createContext();
console.log(TodoStateContext);

function App() {


    const mockData = [
        createMockData(0, false, "React 공부하기", new Date().getTime()),
        createMockData(1, false, "빨래하기", new Date().getTime()),
        createMockData(2, false, "노래 연습하기", new Date().getTime()),
    ];
    const [todos, dispatch] = useReducer(reduce, mockData);
    const idRef = useRef(3);
    const callTodoDispatch = function (type, data) {
        return dispatch({
            type: type,
            data: data
        })
    }

    const onCreate = useCallback((content) => {
        callTodoDispatch("CREATE", createMockData(idRef.current++, false, content, new Date().getTime()));
    }, []);

    const onUpdate = useCallback((targetId) => {
        callTodoDispatch("UPDATE", targetId);
    }, []);

    const onDelete = useCallback((targetId) => {
        callTodoDispatch("DELETE", targetId);
    }, []);

    const memoizedDispatch = useMemo(() => {
        return {
            onCreate,
            onUpdate,
            onDelete
        }
    }, []);

    return (
        <div className="App">
            <Exam/>
            <Header/>
            <TodoStateContext.Provider value={{todos}}>
                <TodoFuncContext.Provider value={memoizedDispatch}>
                    <Editor/>
                    <List/>
                </TodoFuncContext.Provider>
            </TodoStateContext.Provider>
        </div>
    )
}

export default App
