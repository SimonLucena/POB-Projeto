import { Component, OnInit } from '@angular/core';
import { FUNCIONARIOS } from '../../shared/model/FUNCIONARIOS';
import { Funcionario } from '../../shared/model/funcionario';
import { ActivatedRoute } from '@angular/router';
import { FuncionarioService } from '../../shared/servicos/funcionario.service';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css'],
})
export class FuncionarioComponent implements OnInit {
  funcionarioAtual: Funcionario;
  inserindo = true;
  nomeBotao = 'Inserir';

  constructor(
    private rotaAtual: ActivatedRoute,
    private funcionarioService: FuncionarioService
  ) {
    this.funcionarioAtual = new Funcionario(0, '', '', 0);
    if (rotaAtual.snapshot.paramMap.has('id')) {
      const idParaEdicao = rotaAtual.snapshot.paramMap.get('id');
      if (idParaEdicao) {
        this.inserindo = false;
        this.nomeBotao = 'Atualizar';
        const FuncionarioEncontrado = this.funcionarioService
          .pesquisarPorId(idParaEdicao)
          .subscribe(
            (funcionarioEncontrado) =>
              (this.funcionarioService = funcionarioService)
          );
      }
    }
  }

  ngOnInit(): void {}

  inserirOuAtualizarFuncionario() {
    if (this.inserindo) {
      this.funcionarioService
        .inserir(this.funcionarioAtual)
        .subscribe((funcionarioInserido) => console.log(funcionarioInserido));
      this.funcionarioAtual = new Funcionario(0, '', '', 0);
    } else {
      this.funcionarioService
        .atualizar(this.funcionarioAtual)
        .subscribe((funcionarioAtualizado) =>
          console.log(funcionarioAtualizado)
        );
    }
  }

  atualizaNome(novoNome: string) {
    this.funcionarioAtual.nome = novoNome;
  }
}
