import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { UsuarioModel } from '../model/usuario.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http:HttpClient) { 
    console.log("servicio funcionando");
  }

  public getByUsuarioId():Observable<UsuarioModel>{
    return this.http.get<UsuarioModel>("http://localhost:8050/getUsuarioById?usuarioId=1");
  }

  public getByLogin(login:string):Observable<UsuarioModel>{
    console.log(login);
    return this.http.get<UsuarioModel>("http://localhost:8050/getUsuarioByLogin?login="+login);
  }

  getConfig(){
    
  }
  
}
