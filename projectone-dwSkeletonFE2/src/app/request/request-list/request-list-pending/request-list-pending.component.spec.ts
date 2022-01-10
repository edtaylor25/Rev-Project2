import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestListPendingComponent } from './request-list-pending.component';

describe('RequestListPendingComponent', () => {
  let component: RequestListPendingComponent;
  let fixture: ComponentFixture<RequestListPendingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestListPendingComponent ]
    })
    .compileComponents();
  });
  

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestListPendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
