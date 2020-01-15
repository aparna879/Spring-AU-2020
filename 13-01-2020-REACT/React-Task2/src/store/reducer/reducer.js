const initState = {
	userarr:[]
}

const country = (state = initState, action) => {
	if(action.type === 'ON_CLICK_DISPLAY') {
		if(action.userarr){
			return {
			...state,
			userarr: state.userarr.concat(action.userarr)
			}	
		}		
	}
	return state;
}

export default country;