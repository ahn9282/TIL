const Button = ({text, color="black", children}) => {

    const onClickHandler = (e) => {
        console.log({text, color});
        console.log(e);
    }  
    return (
        <button 
            onClick={onClickHandler} 
            onMouseEnter={() => {console.log(text   + "에 마우스가 올라갔습니다.")}}
            style={{ 
                backgroundColor: color, 
                color: 'white',
            }}
        >
            {text}
            {children}
        </button>
    );
 
};

export default Button