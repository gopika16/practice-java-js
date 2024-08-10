import { Component, OnInit, ViewChild } from '@angular/core';
import { AgGridAngular } from 'ag-grid-angular';
import {
  CellClickedEvent,
  ColDef,
  GridReadyEvent,
  RowClickedEvent,
  GridOptions,
  ValueGetterParams,
} from 'ag-grid-community';

import { HttpClientService } from 'src/app/Core/Http-client.service';
import { API, GRIDS } from 'src/app/constants/constants';

@Component({
  selector: 'app-grid-exercise',
  templateUrl: './grid-exercise.component.html',
  styleUrls: ['./grid-exercise.component.css'],
})
export class GridExerciseComponent implements OnInit {
  @ViewChild(AgGridAngular) agGrid!: AgGridAngular;

  public rowData: any[] = [];
  public columnDefs: ColDef[] = [];
  public gridOptions: GridOptions = <GridOptions>{
    groupMultiAutoColumn: true,
    rowGroupPanelShow: 'always',
    allowedAggFuncs: ['sum'],
  };

  public defaultColDef: ColDef = {
    sortable: true,
    filter: true,
  };

  constructor(private _http: HttpClientService) {}

  ngOnInit(): void {
    this.createColDef();
  }

  onRowClicked(event: RowClickedEvent<any, any>): void {
    console.log(event.data.id);
  }

  onGridReady(params: GridReadyEvent): void {
    this._http.get<any[]>(API.PostsApi).subscribe({
      next: (data) => {
        this.rowData = data;
        this.rowData.forEach((data) => {
          if (data.id % 2 === 0) {
            data.isActive = true;
          } else {
            data.isActive = false;
          }
        });
      },
    });
  }

  onCellClicked(event: CellClickedEvent): void {
    console.log('Id : ', event.data.id);
    console.log('user Id : ', event.data.userId);
    console.log('Title : ', event.data.title);
    console.log('Body :', event.data.body);
    console.log('aCtive :', event.data.isActive);
  }
  clearSelection(): void {
    this.agGrid.api.deselectAll();
  }
  createColDef(): void {
    this.columnDefs = [
      { field: 'id', aggFunc: 'sum', rowGroup: true },
      { field: 'userId', hide: true },
      {
        field: 'title',
        editable: true,
        resizable: true,
        pinned: 'right',
        width: 800,
      },
      { field: 'body' },
      {
        field: 'isActive',
        cellRenderer: this.setValue,
        headerName: 'Activity',
        cellClass: 'red',
        rowGroup: true,
      },
    ];
  }
  setValue(params: ValueGetterParams) {
    return params.data.isActive ? GRIDS.YES : GRIDS.NO;
  }
}
