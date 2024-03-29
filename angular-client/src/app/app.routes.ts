import { Routes } from '@angular/router';
import { FixedFileListComponent } from './pages/fixed-file-list/fixed-file-list.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { SpecFileListComponent } from './pages/spec-file-list/spec-file-list.component';
import { RecordListComponent } from './pages/record-list/record-list.component';

export const routes: Routes = [
    {path: '', component: HomepageComponent},
    {path: 'fixed-files', component: FixedFileListComponent},
    {path: 'specification-files', component: SpecFileListComponent},
    {path: 'record', component: RecordListComponent},
];
