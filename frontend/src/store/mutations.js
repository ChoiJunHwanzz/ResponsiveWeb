import {
  //공지사항
  FETCH_GONGZI,
  FETCH_GONGZI_LIST,
  
    
  } from "./mutation-types";
  
  export default {
    
    [FETCH_GONGZI_LIST](state, gongzis) {
      state.gongzis = gongzis;
    },
    [FETCH_GONGZI](state, gongzi) {
      state.gongzi = gongzi;
    },
  };
  