import { Routes } from '@angular/router';
import { FixedFileListComponent } from './pages/fixed-file-list/fixed-file-list.component';
import { SpecFileListComponent } from './pages/spec-file-list/spec-file-list.component';
import { RecordListComponent } from './pages/record-list/record-list.component';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { RecordsByFileComponent } from './pages/records-by-file/records-by-file.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'fixed-files', component: FixedFileListComponent },
  { path: 'specification-files', pathMatch: 'full', component: SpecFileListComponent },
  { path: 'specification-files/records', pathMatch: 'full', component: RecordsByFileComponent },
  { path: 'records', pathMatch: 'full' , component: RecordListComponent },
];
