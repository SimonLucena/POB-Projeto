import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Funcionario } from '../model/funcionario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FuncionarioService {
  URL_FUNCIONARIOS = 'http://localhost:3000/funcionario';

  constructor(private clienteHttp: HttpClient) {}

  listar(): Observable<Funcionario[]> {
    return this.clienteHttp.get<Funcionario[]>(this.URL_FUNCIONARIOS);
  }

  inserir(novoFuncionario: Funcionario): Observable<Funcionario> {
    return this.clienteHttp.post<Funcionario>(
      this.URL_FUNCIONARIOS,
      novoFuncionario
    );
  }

  // DELETE /Funcionarios/3
  apagar(idParaRemocao: string): Observable<object> {
    return this.clienteHttp.delete(`${this.URL_FUNCIONARIOS}/${idParaRemocao}`);
  }

  pesquisarPorId(id: string): Observable<Funcionario> {
    return this.clienteHttp.get<Funcionario>(`${this.URL_FUNCIONARIOS}/${id}`);
  }

  atualizar(Funcionario: Funcionario): Observable<Funcionario> {
    return this.clienteHttp.put<Funcionario>(
      `${this.URL_FUNCIONARIOS}/${Funcionario.id}`,
      Funcionario
    );
  }
}
