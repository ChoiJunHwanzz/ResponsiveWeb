import {

  //공지사항
  FETCH_GONGZI_LIST,
  FETCH_GONGZI,
   
  } from "./mutation-types";

  import axios from "axios";

  export default {
    fetchGongziList({ commit }) {
      return axios.get("http://localhost:7777/gongzi/list").then((res) => {
        commit(FETCH_GONGZI_LIST, res.data);
      });
    },
    fetchGongzi({ commit }, gongziNo) {
      return axios.get(`http://localhost:7777/gongzi/${gongziNo}`).then((res) => {
        commit(FETCH_GONGZI, res.data);
      });
    },
   
  };
  