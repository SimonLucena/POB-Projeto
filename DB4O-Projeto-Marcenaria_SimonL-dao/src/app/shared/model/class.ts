export class Funcionario {
  id: number;
  nome: string;
  cpf: string;
  idade: number;
}

export class Cliente {
  id: number;
  nome: string;
  cpf: string;
  idade: number;
}

export class Produto {
  id: number;
  nome: string;
  preco: number;
}

export class Pedido {
  id: number;
  idFuncionario: Funcionario["id"];
  idCliente: Cliente["id"];
  idProduto: Produto["id"];
}