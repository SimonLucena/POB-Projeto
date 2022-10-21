import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FuncionarioComponent } from './usuario/funcionario/funcionario.component';
import { ClienteComponent } from './usuario/cliente/cliente.component';
import { PedidoComponent } from './usuario/pedido/pedido.component';
import { ProdutoComponent } from './usuario/produto/produto.component';

const routes: Routes = [
  {
    path: 'cliente',
    component: ClienteComponent,
  },
  {
    path: 'funcionario',
    component: FuncionarioComponent,
  },
  {
    path: 'pedido',
    component: PedidoComponent,
  },
  {
    path: 'produto',
    component: ProdutoComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
