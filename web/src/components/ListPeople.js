import React, { Component } from "react";
import { Table, Button, message } from "antd";
import PersonDataService from "../services/PersonDataService";

const { Column } = Table;
export default class ListPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      people: [],
      message: null,
    };
  }

  componentDidMount() {
    this.refreshPeople();
  }

  refreshPeople() {
    PersonDataService.retriveAllPeople().then((response) => {
      console.log(response);
      this.setState({ people: response.data });
    });
  }

  success = (record) => {
    if (record.isVacinada) {
      record.isVacinada = false;
    } else record.isVacinada = true;
    PersonDataService.updatePerson(record, record.codigo);
    message.success("Status alterado com sucesso!");
  };

  render() {
    return (
      <div className="container">
        <h2>PESSOAS CADASTRADAS</h2>
        <div className="container">
          <Table dataSource={this.state.people}>
            <Column title="NOME" dataIndex="nome" key="nome" />
            <Column title="CPF" dataIndex="cpf" key="cpf" />
            <Column title="TELEFONE" dataIndex="telefone" key="telefone" />
            <Column title="EMAIL" dataIndex="email" key="email" />
            <Column
              title="VACINADA"
              dataIndex="isVacinada"
              key="isVacinada"
              render={(text, record) => <p>{String(record.isVacinada)}</p>}
            />
            <Column
              title="ATUALIZAR"
              key="atualizar"
              render={(text, record) => (
                <Button onClick={() => this.success(record)} type="primary">
                  Alterar Status
                </Button>
              )}
            />
          </Table>
        </div>
      </div>
    );
  }
}
