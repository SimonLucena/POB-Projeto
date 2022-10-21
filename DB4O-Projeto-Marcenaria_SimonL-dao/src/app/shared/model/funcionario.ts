export class Funcionario {
  id: number;
  nome: string;
  cpf: string;
  idade: number;
  constructor(id: number, nome: string, cpf: string, idade: number) {
    this.id = id;
    this.cpf = cpf;
    this.idade = idade;
    this.nome = nome;
  }
}