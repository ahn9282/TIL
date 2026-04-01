const Button = ({text, color="black", children}) => {

    const onClickHandler = () => {
        console.log({text, color});
    }  
    return (
        <button onClick={onClickHandler} style={{ backgroundColor: color }}>
            {text}
            {children}
        </button>
    );

};

export default Button