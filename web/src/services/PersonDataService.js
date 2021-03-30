import axios from "axios";

const API_URL = "http://localhost:8080/";

class PersonDataService {
  retriveAllPeople() {
    return axios.get(`${API_URL}people`);
  }

  updatePerson(person, code) {
    return axios.put(`${API_URL}people/${code}`, person);
  }
}

export default new PersonDataService();
