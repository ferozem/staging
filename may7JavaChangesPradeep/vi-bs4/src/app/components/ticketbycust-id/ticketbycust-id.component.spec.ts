import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketbycustIdComponent } from './ticketbycust-id.component';

describe('TicketbycustIdComponent', () => {
  let component: TicketbycustIdComponent;
  let fixture: ComponentFixture<TicketbycustIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketbycustIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketbycustIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
