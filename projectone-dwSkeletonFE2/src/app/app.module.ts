import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { Observable } from 'rxjs';
import { EmployeeComponent } from './users/employee/employee.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './users/login/login.component';
import { RequestComponent } from './request/request.component';
import { HomeComponent } from './home/home.component';
import { RequestListComponent } from './request/request-list/request-list.component';
import { UsersComponent } from './users/users.component';
import { HeaderComponent } from './header/header.component';
import { RequestListPendingComponent } from './request/request-list/request-list-pending/request-list-pending.component';
import { FormsModule } from '@angular/forms';
import { UserDetailsComponent } from './users/user-details/user-details.component';
import { HomeEmployeeComponent } from './home/home-employee/home-employee.component';
import { HomeManagerComponent } from './home/home-manager/home-manager.component';
import { RequestManageComponent } from './request/request-manage/request-manage.component';
import { WelcomeComponent } from './home/welcome/welcome.component';
import { ManagerComponent } from './users/manager/manager.component';
import { ManagerListComponent } from './users/manager/manager-list/manager-list.component';
import { LogoutComponent } from './users/logout/logout.component';



@NgModule({
  declarations: [
    EmployeeComponent,
    AppComponent,
    LoginComponent,
    RequestComponent,
    HomeComponent,
    RequestListComponent,
    UsersComponent,
    HeaderComponent,
    RequestListPendingComponent,
    UserDetailsComponent,
    HomeEmployeeComponent,
    HomeManagerComponent,
    RequestManageComponent,
    WelcomeComponent,
    ManagerComponent,
    ManagerListComponent,
    LogoutComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
